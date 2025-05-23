package com.lec.spring.repository;

import com.lec.spring.domain.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttachmentRepository {

    /**
     * 특정 글(postId)에 첨부파일(들) 추가 INSERT
     * 글 insert, update 시 사용됨.
     *
     * @param list   Map<String, Object> 들의 List
     *               예: <"sourceName", 원본파일명>, <"fileName", 저장된파일명>
     * @param postId 첨부될 글 ID
     * @return DML 수행 결과값
     */

    int insert(@Param("list") List<Map<String, Object>> list,
               @Param("postId") Long postId);

    // 첨부파일 한개 저장 INSERT
    int save(Attachment file);

    // 특정 글(postId)의 첨부파일들 SELECT
    List<Attachment> findByPost(Long postId);

    // 특정 첨부파일(id) 한개 SELECT
    Attachment findById(Long id);

    // 선택된 첨부파일들 SELECT (List 사용)
    List<Attachment> findByIds(@Param("list") List<Long> ids);

    // 선택된 첨부파일들 DELETE (List 사용)
    int deleteByIds(@Param("list") List<Long> ids);

    // 특정 첨부파일 1개 삭제
    int delete(Attachment file);

//    void addFiles(Map<String, MultipartFile> files, Long id);
//
//    Attachment upload(MultipartFile file);
//
//    void delFiles(Attachment file);
//
//    void setImage(List<Attachment> fileList);
}