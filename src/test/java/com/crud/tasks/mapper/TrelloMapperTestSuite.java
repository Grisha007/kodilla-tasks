package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("Trello List Dto", "1", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("Trello Board Dto", "1", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);

        //When
        List<TrelloBoard> mappedTrelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(1, mappedTrelloBoards.size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "Trello List", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("1", "Trello Board", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //When
        List<TrelloBoardDto> mappedTrelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(1, mappedTrelloBoardDto.size());
    }

    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("Trello List Dto", "1", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

        //When
        List<TrelloList> mappedTrelloList = trelloMapper.mapToList(trelloListDtos);

        //When
        assertEquals(1, mappedTrelloList.size());
    }

    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList = new TrelloList("1", "Trello List", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        //When
        List<TrelloListDto> mappedTrelloListDto = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(1, mappedTrelloListDto.size());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Trello Card Dto", "Description", "Pos", "1");

        //When
        TrelloCard mappedTrelloCard = trelloMapper.mapToCard(trelloCardDto);

        assertEquals("Trello Card Dto", mappedTrelloCard.getName());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Trello Card", "Description", "Pos", "1");

        //When
        TrelloCardDto mappedTrelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("Trello Card", mappedTrelloCardDto.getName());
    }
}
