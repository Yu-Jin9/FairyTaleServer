package com.fairytale.server.service.announcement;

import com.fairytale.server.model.announcement.dto.AnnouncementDto;

import java.util.List;

public interface AnnouncementService {

    void insertAnnouncement(AnnouncementDto announcementDto);

    Integer getTotalCount();

    List<AnnouncementDto> AnnouncementList(AnnouncementDto announcementDto);

    List<AnnouncementDto> viewAnnouncementList(AnnouncementDto announcementDto);

    AnnouncementDto selectAnnouncement(AnnouncementDto announcementDto);

    void announcementView(AnnouncementDto announcementDto);

    void deleteAnnouncement(AnnouncementDto announcementDto);

    List<AnnouncementDto> selectTitle(AnnouncementDto announcementDto);
}
