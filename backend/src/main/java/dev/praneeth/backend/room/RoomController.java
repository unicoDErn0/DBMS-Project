package dev.praneeth.backend.room;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> GetRooms() {
        return roomService.GetRooms();
    }

    @PostMapping
    public void AddRoom(@RequestBody Room room) {
        roomService.AddRoom(room);
    }

    @DeleteMapping(path = "/{roomId}")
    public void DeleteRoom(@PathVariable("roomId") Integer roomId) {
        roomService.DeleteRoom(roomId);
    }

    @PutMapping(path = "/{roomId}")
    public void UpdateRoom(@PathVariable("roomId") Integer roomId, @RequestBody RoomUpdateRequest updateRequest) {
        roomService.updateRoom(roomId, updateRequest);
    }
}
