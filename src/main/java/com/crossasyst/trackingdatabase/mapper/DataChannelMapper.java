package com.crossasyst.trackingdatabase.mapper;

import com.crossasyst.trackingdatabase.entity.DataChannelEntity;
import com.crossasyst.trackingdatabase.model.DataChannel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataChannelMapper {

    DataChannelEntity modelToEntity(DataChannel dataChannel);

}
