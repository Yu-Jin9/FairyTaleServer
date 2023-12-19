package com.fairytale.server.service.member;

import com.fairytale.server.model.member.dto.MemberDto;
import com.fairytale.server.model.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public int regist(MemberDto memberDto) {
        return memberMapper.regist(memberDto);
    }

    @Override
    public MemberDto idCheck(MemberDto memberDto) { return memberMapper.idCheck(memberDto); }

    @Override
    public MemberDto login(MemberDto memberDto) {
        return memberMapper.login(memberDto);
    }

    @Override
    public MemberDto userProfile(MemberDto memberDto) {
        return memberMapper.userProfile(memberDto);
    }

    @Override
    public MemberDto checkPassword(MemberDto memberDto) {
        MemberDto password = memberMapper.checkPassword(memberDto);
        return password;
    }

    @Override
    public int modifyNick(MemberDto memberDto) {
        return memberMapper.modifyNick(memberDto);
    }
    @Override
    public int modifyPw(MemberDto memberDto) {
        return memberMapper.modifyPw(memberDto);
    }
    @Override
    public int modifyProfile(MemberDto memberDto) {
        return memberMapper.modifyProfile(memberDto);
    }

    @Override
    public MemberDto getNewInfo(MemberDto memberDto) {
        return memberMapper.getNewInfo(memberDto);
    }

    @Override
    public int delete(MemberDto memberDto) {
        return memberMapper.delete(memberDto);
    }

    @Override
    public MemberDto checkMembership(MemberDto memberDto) {
        return memberMapper.checkMembership(memberDto);
    }

    @Override
    public void setMembership(MemberDto memberDto){
        memberMapper.setMembership(memberDto);
    }

    @Override
    public List<MemberDto> memberList(MemberDto memberDto) { return memberMapper.memberList(memberDto); }

    @Override
    public List<MemberDto> payMemberList(MemberDto memberDto) { return memberMapper.payMemberList(memberDto); }

    @Override
    public Integer getMemberTotalCount() { return memberMapper.getMemberTotalCount(); }
}
