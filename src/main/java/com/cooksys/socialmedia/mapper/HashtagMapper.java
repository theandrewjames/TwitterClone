package com.cooksys.socialmedia.mapper;

import com.cooksys.socialmedia.dto.HashtagRequestDto;
import com.cooksys.socialmedia.dto.HashtagResponseDto;
import com.cooksys.socialmedia.entity.Hashtag;
import org.mapstruct.Mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface HashtagMapper {
    HashtagResponseDto hashtagEntityToResponseDto (Hashtag hashtag);
    List<HashtagResponseDto> hashtagEntitiesToResponseDtos (List<Hashtag> hashtags);
    Hashtag hashtagRequestDtoToEntity (HashtagRequestDto hashtagRequestDto);    
    default LocalDateTime map(Timestamp timestamp ) {
    	 return timestamp.toLocalDateTime();
    }
    default Timestamp map(LocalDateTime localDateTime) {
		return Timestamp.valueOf(localDateTime);
    }

}
