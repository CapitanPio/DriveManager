package com.drive.drive_manager.controller;

import com.drive.drive_manager.dto.Card;
import com.drive.drive_manager.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for Card CRUD operations.
 */
@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    /**
     * Create a new card.
     * POST /api/cards
     */
    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        Card createdCard = cardService.createCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCard);
    }

    /**
     * Get card by ID.
     * GET /api/cards/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable String id) {
        Optional<Card> card = cardService.getCardById(id);
        return card.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Get all cards.
     * GET /api/cards
     */
    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    /**
     * Update a card by ID.
     * PUT /api/cards/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable String id, @RequestBody Card cardDetails) {
        Optional<Card> updatedCard = cardService.updateCard(id, cardDetails);
        return updatedCard.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Delete a card by ID.
     * DELETE /api/cards/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable String id) {
        boolean deleted = cardService.deleteCard(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Find cards by name.
     * GET /api/cards/search/name?cardName=...
     */
    @GetMapping("/search/name")
    public ResponseEntity<List<Card>> findCardsByName(@RequestParam String cardName) {
        List<Card> cards = cardService.findCardsByName(cardName);
        return ResponseEntity.ok(cards);
    }

    /**
     * Find cards by type.
     * GET /api/cards/search/type?cardType=...
     */
    @GetMapping("/search/type")
    public ResponseEntity<List<Card>> findCardsByType(@RequestParam String cardType) {
        List<Card> cards = cardService.findCardsByType(cardType);
        return ResponseEntity.ok(cards);
    }

    /**
     * Find cards by edition.
     * GET /api/cards/search/edition?edition=...
     */
    @GetMapping("/search/edition")
    public ResponseEntity<List<Card>> findCardsByEdition(@RequestParam String edition) {
        List<Card> cards = cardService.findCardsByEdition(edition);
        return ResponseEntity.ok(cards);
    }

    /**
     * Find cards by regulation.
     * GET /api/cards/search/regulation?regulation=...
     */
    @GetMapping("/search/regulation")
    public ResponseEntity<List<Card>> findCardsByRegulation(@RequestParam String regulation) {
        List<Card> cards = cardService.findCardsByRegulation(regulation);
        return ResponseEntity.ok(cards);
    }

    /**
     * Find cards by card class.
     * GET /api/cards/search/class?cardClass=...
     */
    @GetMapping("/search/class")
    public ResponseEntity<List<Card>> findCardsByClass(@RequestParam String cardClass) {
        List<Card> cards = cardService.findCardsByClass(cardClass);
        return ResponseEntity.ok(cards);
    }

    /**
     * Find all starter cards.
     * GET /api/cards/search/starter
     */
    @GetMapping("/search/starter")
    public ResponseEntity<List<Card>> findStarterCards() {
        List<Card> cards = cardService.findStarterCards();
        return ResponseEntity.ok(cards);
    }
}
