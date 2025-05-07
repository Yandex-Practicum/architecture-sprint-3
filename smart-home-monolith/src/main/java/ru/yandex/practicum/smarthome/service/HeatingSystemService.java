package ru.yandex.practicum.smarthome.service;

import ru.yandex.practicum.smarthome.dto.HeatingSystemDto;

public interface HeatingSystemService {
    //мониторинг
    Double getCurrentTemperature(Long id);
    HeatingSystemDto getHeatingSystem(Long id);

    //управление
    HeatingSystemDto updateHeatingSystem(Long id, HeatingSystemDto heatingSystemDto);
    void setTargetTemperature(Long id, double temperature);
    void turnOn(Long id);
    void turnOff(Long id);
}