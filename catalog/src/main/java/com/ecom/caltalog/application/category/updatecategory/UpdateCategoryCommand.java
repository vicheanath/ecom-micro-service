package com.ecom.caltalog.application.category.updatecategory;

import com.ecom.shared.application.Command;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateCategoryCommand implements Command<Void> {

    @NotEmpty
    private String id;
    @NotEmpty
    private String name;
    @Max(255)
    private String description;
    private String parentId;
}
