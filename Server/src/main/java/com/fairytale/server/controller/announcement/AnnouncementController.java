package com.fairytale.server.controller.announcement;

import com.fairytale.server.model.announcement.dto.AnnouncementDto;
import com.fairytale.server.model.board.dto.BoardDto;
import com.fairytale.server.service.announcement.AnnouncementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/server/announcement")
public class AnnouncementController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AnnouncementService announcementService;

    // 최신순 리스트
    @PostMapping("/announcementList")
    @ResponseBody
    public HashMap<String, Object> AnnouncementList(@RequestBody AnnouncementDto announcementDto) {
        HashMap<String, Object> mv = new HashMap<>();

        List<AnnouncementDto> list = announcementService.AnnouncementList(announcementDto);

        int totalCount = announcementService.getTotalCount();
        int pageSize = announcementDto.getPageSize();
        int currentPage = announcementDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("announcementList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    // 조회수 순 리스트
    @PostMapping("/viewAnnouncementList")
    @ResponseBody
    public HashMap<String, Object> viewAnnouncementList(@RequestBody AnnouncementDto announcementDto) {

        HashMap<String, Object> mv = new HashMap<>();

        List<AnnouncementDto> list = announcementService.viewAnnouncementList(announcementDto);

        int totalCount = announcementService.getTotalCount();
        int pageSize = announcementDto.getPageSize();
        int currentPage = announcementDto.getCurrentPage();
        int totalPages = (int) Math.ceil((double) totalCount / (currentPage * pageSize));

        mv.put("announcementList", list);
        mv.put("totalPages", totalPages);

        return mv;
    }

    @PostMapping("/insertAnnouncement")
    @ResponseBody
    public void insertAnnouncement(@RequestBody AnnouncementDto announcementDto) {
        announcementService.insertAnnouncement(announcementDto);
    }

    // 선택한 게시물 가져오기
    @PostMapping("/selectAnnouncement")
    @ResponseBody
    public HashMap<String, Object> selectAnnouncement(@RequestBody AnnouncementDto announcementDto) {

        HashMap<String, Object> mv = new HashMap<>();

        announcementDto = announcementService.selectAnnouncement(announcementDto);

        mv.put("selectAnnouncement", announcementDto);

        return mv;
    }

    // 조회수
    @PostMapping("/announcementView")
    @ResponseBody
    public void announcementView(@RequestBody AnnouncementDto announcementDto) {
        announcementService.announcementView(announcementDto);
    }

    @PostMapping("/deleteAnnouncement")
    @ResponseBody
    public void deleteAnnouncement(@RequestBody AnnouncementDto announcementDto) {
        announcementService.deleteAnnouncement(announcementDto);
    }

    @PostMapping("/selectTitle")
    @ResponseBody
    public HashMap<String, Object> selectTitle(@RequestBody AnnouncementDto announcementDto) {

        HashMap<String, Object> mv = new HashMap<>();

        List<AnnouncementDto> list = announcementService.selectTitle(announcementDto);

        mv.put("selectTitle", list);

        return mv;
    }
}
