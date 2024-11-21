package com.ecom.caltalog.application.category.createcategory;

import com.ecom.shared.application.Command;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateCategoryCommand implements Command<Void> {

    public String name;
    public String description;
    public String parentId;
}
