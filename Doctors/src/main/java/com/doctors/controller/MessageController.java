package com.doctors.controller;

import com.doctors.model.MessageModel;
import com.doctors.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/message")
@CrossOrigin(origins = "*")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/{idMessage}")
    public Optional<MessageModel> getMessage(@PathVariable Integer idMessage){ return messageService.getMessage(idMessage);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel saveMessage(@RequestBody MessageModel messageModel){ return messageService.saveMessage(messageModel);
    }

    @DeleteMapping("/delete/{idMessage}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMessage(@PathVariable Integer idMessage){ return messageService.deleteMessage(idMessage);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageModel updateMessage(@RequestBody MessageModel messageModel){ return messageService.updateMessage(messageModel);
    }
}
