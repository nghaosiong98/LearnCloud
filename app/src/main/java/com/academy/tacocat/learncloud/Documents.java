package com.academy.tacocat.learncloud;

import java.util.ArrayList;
import java.util.List;

public class Documents {
    public List<Section> section = new ArrayList<>();

}
class Section{
    public String title;
    public List<Dataset> dataset = new ArrayList<>();
}

class Dataset{
    public String content_title;
    public String description;
    public String content;
}
