package com.mainaud.essai.pattern.builder.model_5_lombok;

import com.mainaud.essai.pattern.builder.api.CépageLec;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;


@Getter
@AllArgsConstructor
public final class Cépage {
    @NonNull
    private String nom;
    private String description;

}
