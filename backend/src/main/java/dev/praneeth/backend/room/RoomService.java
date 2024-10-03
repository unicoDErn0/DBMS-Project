package dev.praneeth.backend.room;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // Get all rooms
    public List<Room> GetRooms() {
        return roomRepository.findAll();
    }

    // Add a new room
    public void AddRoom(Room room) {
        roomRepository.save(room);
    }

    // Delete a room by ID
    public void DeleteRoom(Integer roomId) {
        boolean exists = roomRepository.existsById(roomId);
        if (!exists) {
            throw new IllegalStateException("Room with ID " + roomId + " does not exist.");
        }
        roomRepository.deleteById(roomId);
    }

    // Update a room by ID
    public void updateRoom(Integer roomId, RoomUpdateRequest updateRequest) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new IllegalStateException("Room with ID " + roomId + " does not exist."));

        if (updateRequest.getRoomNumber() != null && !updateRequest.getRoomNumber().isEmpty()) {
            room.setRoomNumber(updateRequest.getRoomNumber());
        }
        if (updateRequest.getRoomType() != null) {
            room.setRoomType(updateRequest.getRoomType());
        }
        if (updateRequest.getStatus() != null) {
            room.setStatus(updateRequest.getStatus());
        }

        roomRepository.save(room);
    }
}
