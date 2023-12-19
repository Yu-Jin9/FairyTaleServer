package com.fairytale.server.controller.member;

import com.fairytale.server.model.member.dto.MemberDto;
import com.fairytale.server.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/server/member")
public class MemberController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MemberService memberService;

    @PostMapping("/regist") // 회원가입
    @ResponseBody   
    public HashMap<String, Object> regist(@RequestBody MemberDto memberDto) {

        HashMap<String,  Object> mv = new HashMap<>();

        int resultCnt = memberService.regist(memberDto);

        mv.put("result", resultCnt);

        return mv;
    }

    @PostMapping("/idCheck")    // 아이디 중복 확인
    @ResponseBody
    public HashMap<String, Object> idCehck(@RequestParam String id) {

        HashMap<String, Object> mv = new HashMap<>();

        MemberDto memberDto = new MemberDto();
        memberDto.setId(id);

        MemberDto resultCnt = memberService.idCheck(memberDto);

        mv.put("result", resultCnt);

        return mv;
    }

    @PostMapping("/login")  // 로그인
    @ResponseBody
    public HashMap<String, Object> login(@RequestBody MemberDto memberDto) {

        HashMap<String, Object> mv = new HashMap<>();
        MemberDto resultCnt = memberService.login(memberDto);

        mv.put("result", resultCnt);

        return mv;
    }

    @PostMapping("/userProfile")    // 내 정보 페이지 _ 사용자 정보
    @ResponseBody
    public HashMap<String, Object> userProfile(@RequestBody MemberDto memberDto) {

        HashMap<String, Object> mv = new HashMap<>();

        MemberDto resultData = memberService.userProfile(memberDto);

        mv.put("result", resultData);

        return mv;
    }

    @PostMapping("/checkPassword")    // 현재 비밀번호 확인 (내 정보 수정시)
    @ResponseBody
    public HashMap<String, Object> checkPassword(@RequestBody MemberDto memberDto) {

        HashMap<String, Object> mv = new HashMap<>();

        MemberDto resultData = memberService.checkPassword(memberDto);

        if(resultData != null) {
            mv.put("result", true);
        }
        else { mv.put("result", false);}

        return mv;
    }

    @PostMapping("/modify")    // 내 정보 수정
    @ResponseBody
    public void modify(@RequestBody MemberDto memberDto) {

        if (memberDto.getNick() != null) {
            memberService.modifyNick(memberDto);
        }
        if (memberDto.getPw() != null) {
            memberService.modifyPw(memberDto);
        }
        if (memberDto.getProfile() != null) {
            memberService.modifyProfile(memberDto);
        }
    }

    @PostMapping("/getNewInfo") // 정보 수정 후 context에 새로운 정보 담기 위함
    @ResponseBody
    public HashMap<String, Object> getNewInfo(@RequestBody MemberDto memberDto) {

        HashMap<String, Object> mv = new HashMap<>();

        MemberDto resultData = memberService.getNewInfo(memberDto);
        mv.put("result", resultData);

        return mv;
    }

    @PostMapping("/delete")     // 회원 삭제
    @ResponseBody
    public HashMap<String, Object> delete(@RequestBody MemberDto memberDto) {

        HashMap<String,  Object> mv = new HashMap<>();

        int resultCnt = memberService.delete(memberDto);
        mv.put("result", resultCnt);

        return mv;
    }

    @PostMapping("/setMembership")
    @ResponseBody
    public  void setMembership(@RequestBody MemberDto memberDto) {
        memberService.setMembership(memberDto);
    }

    @PostMapping("/checkMembership")
    @ResponseBody
    public HashMap<String,Object> checkMembership(@RequestBody MemberDto memberDto) {
        HashMap<String, Object> mv = new HashMap<>();

        MemberDto resultData = memberService.checkMembership(memberDto);

        mv.put("result", resultData);

        return mv;
    }

    @PostMapping("/memberList")
    @ResponseBody
    public HashMap<String, Object> memberList(@RequestBody MemberDto memberDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<MemberDto> list = memberService.memberList(memberDto);

        int totalCount = memberService.getMemberTotalCount();
        int pageSize = memberDto.getPageSize();
        int currentPage = memberDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("memberList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    @PostMapping("payMemberList")
    @ResponseBody
    public HashMap<String, Object> payMemberList(@RequestBody MemberDto memberDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<MemberDto> list = memberService.payMemberList(memberDto);

        int totalCount = memberService.getMemberTotalCount();
        int pageSize = memberDto.getPageSize();
        int currentPage = memberDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("payMemberList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }



}
