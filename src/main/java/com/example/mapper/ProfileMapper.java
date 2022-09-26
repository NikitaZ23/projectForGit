package com.example.mapper;

import com.example.domain.Profile;
import com.example.dto.ProfileDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileDto map(Profile profile);

    Iterable<ProfileDto> map(Iterable<Profile> profiles);
}
