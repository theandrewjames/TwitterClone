package com.cooksys.socialmedia.mapper;

import com.cooksys.socialmedia.dto.HashtagRequestDto;
import com.cooksys.socialmedia.dto.HashtagResponseDto;
import com.cooksys.socialmedia.entity.Hashtag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
    HashtagResponseDto hashtagEntityToResponseDto (Hashtag hashtag);
    List<HashtagResponseDto> hashtagEntitiesToResponseDtos (List<Hashtag> hashtags);
    Hashtag hashtagRequestDtoToEntity (HashtagRequestDto hashtagRequestDto);

}
