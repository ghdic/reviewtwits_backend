package com.reviewtwits.message.request;

import lombok.Data;

@Data
public class ProjectReq {
    String summary;
    String category;
    int reviewStyle;
    String customCss;
    int aiPositiveNegative;
}
