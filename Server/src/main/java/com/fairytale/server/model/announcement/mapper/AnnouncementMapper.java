package com.fairytale.server.model.announcement.mapper;

import com.fairytale.server.model.announcement.dto.AnnouncementDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementMapper {

    void insertAnnouncement(AnnouncementDto announcementDto);

    Integer getTotalCount();

    List<AnnouncementDto> AnnouncementList(AnnouncementDto announcementDto);

    List<AnnouncementDto> viewAnnouncementList(AnnouncementDto announcementDto);

    AnnouncementDto selectAnnouncement(AnnouncementDto announcementDto);

    void announcementView(AnnouncementDto announcementDto);

    void deleteAnnouncement(AnnouncementDto announcementDto);

    List<AnnouncementDto> selectTitle(AnnouncementDto announcementDto);
}
