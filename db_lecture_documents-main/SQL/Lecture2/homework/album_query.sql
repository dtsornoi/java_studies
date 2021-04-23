SELECT 
	AlbumName, 
	DateReleased
FROM Albums
ORDER BY DateReleased DESC LIMIT 1;

SELECT 
	AlbumName,
    max(DateReleased)
FROM Albums
GROUP BY AlbumName;

SELECT 
	AlbumName,
    DateReleased
FROM Albums
Where DateReleased 
IN (SELECT MAX(DateReleased) FROM albums);