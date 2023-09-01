package com.example.cdacproject.notificationapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cdacproject.notificationapi.model.Notification;
import com.example.cdacproject.notificationapi.repository.NotificationRepository;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	
	private NotificationRepository notificationRepository;

	@Autowired
	public NotificationController(NotificationRepository notificationRepository) {
		super();
		this.notificationRepository = notificationRepository;
	}
	
	@PostMapping
	public Notification createNotification(@RequestBody Notification notification) {
		
		return notificationRepository.save(notification);
	}
	
	@GetMapping
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
	
	 @GetMapping("/{id}")
	    public Optional<Notification> getNotificationById(@PathVariable Long id) {
	        return notificationRepository.findById(id);
	    }
	 
	 
	 @PutMapping("/{id}")
	    public Notification updateNotification(@PathVariable Long id, @RequestBody Notification updatedNotification) {
	        updatedNotification.setId(id); // Ensure the ID matches the path variable
	        return notificationRepository.save(updatedNotification);
	    }
	 
	 
	 @DeleteMapping("/{id}")
	    public void deleteNotification(@PathVariable Long id) {
	        notificationRepository.deleteById(id);
	    }
	
	
	
	

}
