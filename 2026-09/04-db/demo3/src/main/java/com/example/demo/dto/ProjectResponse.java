package com.example.demo.dto;

import java.util.List;

public record ProjectResponse(Long id, String name, List<String> tasks) {
}
