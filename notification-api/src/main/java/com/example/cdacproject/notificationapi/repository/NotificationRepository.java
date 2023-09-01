package com.example.cdacproject.notificationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cdacproject.notificationapi.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
