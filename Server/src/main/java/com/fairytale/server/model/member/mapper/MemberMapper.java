package com.fairytale.server.model.member.mapper;

import com.fairytale.server.model.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    int regist (MemberDto memberDto);

    MemberDto idCheck (MemberDto memberDto);

    MemberDto login (MemberDto memberDto);

    MemberDto userProfile (MemberDto memberDto);

    MemberDto checkPassword (MemberDto memberDto);

    int modifyNick (MemberDto memberDto);
    int modifyPw (MemberDto memberDto);
    int modifyProfile (MemberDto memberDto);

    MemberDto getNewInfo (MemberDto memberDto);

    int delete (MemberDto memberDto);

    MemberDto checkMembership (MemberDto memberDto);

    void setMembership (MemberDto memberDto);

    List<MemberDto> memberList (MemberDto memberDto);

    List<MemberDto> payMemberList (MemberDto memberDto);

    Integer getMemberTotalCount();
}
