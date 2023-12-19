package com.fairytale.server.service.announcement;

import com.fairytale.server.model.announcement.dto.AnnouncementDto;
import com.fairytale.server.model.announcement.mapper.AnnouncementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementMapper announcementMapper;


    @Override
    public void insertAnnouncement(AnnouncementDto announcementDto) {
        announcementMapper.insertAnnouncement(announcementDto);
    }

    @Override
    public Integer getTotalCount() {
        return announcementMapper.getTotalCount();
    }

    @Override
    public List<AnnouncementDto> AnnouncementList(AnnouncementDto announcementDto) {
        return announcementMapper.AnnouncementList(announcementDto);
    }

    @Override
    public List<AnnouncementDto> viewAnnouncementList(AnnouncementDto announcementDto) {
        return announcementMapper.viewAnnouncementList(announcementDto);
    }

    @Override
    public AnnouncementDto selectAnnouncement(AnnouncementDto announcementDto) {
        return announcementMapper.selectAnnouncement(announcementDto);
    }

    @Override
    public void announcementView(AnnouncementDto announcementDto) {
        announcementMapper.announcementView(announcementDto);
    }

    @Override
    public void deleteAnnouncement(AnnouncementDto announcementDto) {
        announcementMapper.deleteAnnouncement(announcementDto);
    }

    @Override
    public List<AnnouncementDto> selectTitle(AnnouncementDto announcementDto) {
        return announcementMapper.selectTitle(announcementDto);
    }
}
