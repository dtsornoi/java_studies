SELECT 
	AlbumName, 
    count(GenreID) 
FROM albums
GROUP BY GenreId