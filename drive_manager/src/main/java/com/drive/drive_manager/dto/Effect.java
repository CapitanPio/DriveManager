package com.drive.drive_manager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Effect DTO representing a card effect with instance, restrictions, triggers, and resolution.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Effect {

    private String instance;
    private String restriction;
    private String trigger;
    private String cost;
    private String resolution;
    private String kind;
    private List<String> tags;

    public String getPlainEffect(){
        StringBuilder plainEffect = new StringBuilder();
        if (instance != null) plainEffect.append("<").append(instance).append("> ");
        if ("once per turn".equals(restriction)) plainEffect.append("[").append(restriction).append("] ");
        if ("once per copies per turn".equals(restriction)) plainEffect.append("(1)").append(" ");
        if (trigger != null) plainEffect.append(trigger).append(": ");
        if (cost != null) plainEffect.append(cost).append("; ");
        if (resolution != null) plainEffect.append(resolution).append(" ");
        if (kind != null) plainEffect.append(kind).append(" ");
        if (tags != null && !tags.isEmpty()) plainEffect.append(String.join(", ", tags));
        return plainEffect.toString().trim();
    }

    private class subEffect {
        private String instance;
        private String restriction;
        private String trigger;
        private String cost;
        private String resolution;
        private String kind;
        private List<String> tags;

        public String getPlainEffect(){
            StringBuilder plainEffect = new StringBuilder();
            if (instance != null) plainEffect.append("<").append(instance).append("> ");
            if ("once per turn".equals(restriction)) plainEffect.append("[").append(restriction).append("] ");
            if ("once per copies per turn".equals(restriction)) plainEffect.append("(1)").append(" ");
            if (trigger != null) plainEffect.append(trigger).append(": ");
            if (cost != null) plainEffect.append(cost).append("; ");
            if (resolution != null) plainEffect.append(resolution).append(" ");
            if (kind != null) plainEffect.append(kind).append(" ");
            if (tags != null && !tags.isEmpty()) plainEffect.append(String.join(", ", tags));
            return plainEffect.toString().trim();
        }
    }
}
