package com.homework.task4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Video video1 = new Video("video1", "www", VideoType.EPISODE);
        Video video2 = new Video("video2", "111", VideoType.CLIP);
        Video video3 = new Video("video3", "222", VideoType.PREVIEW);
        Video video4 = new Video("video4", "333", VideoType.EPISODE);
        Video video5 = new Video("video5", "444", VideoType.CLIP);
        Video video6 = new Video("video6", "555", VideoType.PREVIEW);
        Video video7 = new Video("video7", "666", VideoType.EPISODE);
        Video video8 = new Video("video8", "777", VideoType.CLIP);
        Video video9 = new Video("video9", "888", VideoType.PREVIEW);
        Video video10 = new Video("video10", "999", VideoType.EPISODE);
        Video video11 = new Video("video11", "1010", VideoType.CLIP);
        Video video12 = new Video("video12", "1111", VideoType.PREVIEW);

        List<Video> list1 = List.of(video1, video2, video3);
        List<Video> list2 = List.of(video4, video5, video6);
        List<Video> list3 = List.of(video7, video8, video9);
        List<Video> list4 = List.of(video10, video11, video12);

        Episode episode1 = new Episode("ep1", 1, list1);
        Episode episode2 = new Episode("ep2", 2, list2);
        Episode episode3 = new Episode("ep3", 3, list3);
        Episode episode4 = new Episode("ep4", 4, list4);

        List<Episode> episodeList1 = List.of(episode1, episode2);
        List<Episode> episodeList2 = List.of(episode3, episode4);

        Season season1 = new Season("s1", 1, episodeList1);
        Season season2 = new Season("s2", 2, episodeList2);

        List<Season> collectionOfAll = List.of(season1, season2);

        var listOfAllEpisodes = collectionOfAll.stream()
                .flatMap(season -> season.episodes.stream())
                .collect(Collectors.toList());

        var listOfAllVideos = collectionOfAll.stream()
                .flatMap(season -> season.episodes.stream())
                .flatMap(episode -> episode.videos.stream())
                .collect(Collectors.toList());

        var listOfAllSeasonNames = Stream.of(season1, season2)
                .map(season -> season.seasonName)
                .collect(Collectors.toList());

        var listOfAllSeasonNumbers = Stream.of(season1, season2)
                .map(season -> season.seasonNumber)
                .collect(Collectors.toList());

        var listOfAllEpisodeNames = listOfAllEpisodes.stream()
                .map(episode -> episode.episodeName)
                .collect(Collectors.toList());

        var listOfAllEpisodeNumbers = listOfAllEpisodes.stream()
                .map(episode -> episode.episodeNumber)
                .collect(Collectors.toList());

        var listOfAllVideoNames = listOfAllVideos.stream()
                .map(video -> video.title)
                .collect(Collectors.toList());

        var listOfAllUrlAddressesForEachVideo = listOfAllVideos.stream()
                .map(video -> video.url)
                .collect(Collectors.toList());

        var onlyEpisodesFromEvenSeasons = collectionOfAll.stream()
                .filter(season -> isEven(season.seasonNumber))
                .flatMap(season -> season.episodes.stream())
                .collect(Collectors.toList());

        var onlyVideosFromEvenSeasons = collectionOfAll.stream()
                .filter(season -> isEven(season.seasonNumber))
                .flatMap(season -> season.episodes.stream())
                .flatMap(episode -> episode.videos.stream())
                .collect(Collectors.toList());

        var onlyVideosFromEvenSeasonsAndEvenEpisodes = collectionOfAll.stream()
                .filter(season -> isEven(season.seasonNumber))
                .flatMap(season -> season.episodes.stream())
                .filter(episode -> isEven(episode.episodeNumber))
                .flatMap(episode -> episode.videos.stream())
                .collect(Collectors.toList());

        var onlyClipVideosFromEvenEpisodesAndOddSeasons = collectionOfAll.stream()
                .filter(season -> !isEven(season.seasonNumber))
                .flatMap(season -> season.episodes.stream())
                .filter(episode -> isEven(episode.episodeNumber))
                .flatMap(episode -> episode.videos.stream())
                .filter(video -> video.videoType == VideoType.CLIP)
                .collect(Collectors.toList());

        var onlyPreviewVideosFromOddEpisodesAndEvenSeasons = collectionOfAll.stream()
                .filter(season -> isEven(season.seasonNumber))
                .flatMap(season -> season.episodes.stream())
                .filter(episode -> !isEven(episode.episodeNumber))
                .flatMap(episode -> episode.videos.stream())
                .filter(video -> video.videoType == VideoType.PREVIEW)
                .collect(Collectors.toList());
    }

    private static boolean isEven(int number) {
        if (number % 2 == 0)
            return true;
        return false;
    }
}

enum VideoType {
    CLIP,
    PREVIEW,
    EPISODE
}

class Video {
    public String title;
    public String url;
    public VideoType videoType;

    public Video(String title, String url, VideoType videoType) {
        this.title = title;
        this.url = url;
        this.videoType = videoType;
    }
}

class Episode {
    public String episodeName;
    public int episodeNumber;
    List<Video> videos;

    public Episode(String episodeName, int episodeNumber, List<Video> videos) {
        this.episodeName = episodeName;
        this.episodeNumber = episodeNumber;
        this.videos = videos;
    }
}

class Season {
    public String seasonName;
    public int seasonNumber;
    List<Episode> episodes;

    public Season(String seasonName, int seasonNumber, List<Episode> episodes) {
        this.seasonName = seasonName;
        this.seasonNumber = seasonNumber;
        this.episodes = episodes;
    }
}
