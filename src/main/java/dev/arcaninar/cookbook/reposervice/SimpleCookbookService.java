package dev.arcaninar.cookbook.reposervice;

import dev.arcaninar.cookbook.docobjects.SimpleCookbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleCookbookService {
    private final SimpleCookbookRepository simpleCookbookRepository;
    private final BackblazeService backblazeService;

    @Autowired
    public SimpleCookbookService(SimpleCookbookRepository simpleCookbookRepository, BackblazeService backblazeService) {
        this.simpleCookbookRepository = simpleCookbookRepository;
        this.backblazeService = backblazeService;
    }

    private List<SimpleCookbook> convertImageToBase64(List<SimpleCookbook> simpleCookbookList) {
        for (SimpleCookbook simpleCookbook: simpleCookbookList) {
            simpleCookbook.setImage(backblazeService.getImageBase64(simpleCookbook.getImage()));
        }
        return simpleCookbookList;
    }

    public List<SimpleCookbook> allSimpleCookbooks() {
        List<SimpleCookbook> simpleCookbookList = simpleCookbookRepository.findAll();
        return convertImageToBase64(simpleCookbookList);
    }

    public List<SimpleCookbook> SimpleCookbooksByKeyword(String keyword) {
        List<SimpleCookbook> simpleCookbookList = simpleCookbookRepository.findByKeyword(keyword);
        return convertImageToBase64(simpleCookbookList);
    }
}