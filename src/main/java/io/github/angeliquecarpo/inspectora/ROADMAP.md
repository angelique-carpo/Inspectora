# Inspectora Roadmap

## ✅ Completed

- [x] Queue-based crawler
- [x] HtmlFetcher
- [x] ContentAnalyzer
- [x] Ignore non-HTML resources
- [x] Page classification (OK / THIN / VERY THIN / EMPTY)
- [x] ReportEntry
- [x] ReportGenerator
- [x] Single-fetch analysis flow
- [x] Refactored crawler architecture
- [x] UrlProvider
- [x] SitemapReader
- [x] XML sitemap support
- [x] Recursive sitemap index support (`sitemap_index.xml`)
- [x] Graceful handling of HTTP errors during crawling
- [x] robots.txt sitemap discovery
- [x] HTML sitemap fallback
- [x] Homepage crawl fallback
- [x] Non-HTML resource filtering
- [x] Excel export
- [x] Excel report summary
- [x] Excel status coloring
- [x] Excel filtering
- [x] Excel frozen table header
- [x] H1 Analyzer
- [x] ALT Analyzer
- [x] Meta Description Analyzer
- [x] SEO Score
- [x] SEO Score coloring
- [x] Internal Link Analyzer
- [x] Internal link status (OK / NO INTERNAL LINKS)
- [x] Broken Internal Link Analyzer
- [x] Broken internal link detection
- [x] Broken link status in Excel report
- [x] Broken link status coloring
- [x] Improve Excel report formatting

---

## 📋 Next Steps

- [ ] Add overall website SEO summary
- [ ] Improve SEO scoring rules

---

## ✅ Current Version

v0.11

---

## 📜 Changelog

### v0.10

- Added Internal Link Analyzer
- Added internal link status reporting
- Added Broken Internal Link Analyzer
- Added broken internal link detection
- Added broken link status to Excel reports
- Added broken link status coloring in Excel
- Preserved single-fetch analysis flow

### v0.9

- Added H1 analysis
- Added ALT analysis
- Added meta description analysis
- Added SEO scoring
- Added SEO score visualization in Excel

### v0.8

- Added Excel report export
- Added website information to Excel reports
- Added summary statistics to Excel reports
- Added status-based cell coloring
- Added filtering to report tables
- Added frozen table header
- Improved Excel report usability

### v0.7

- Added UrlProvider
- Added SitemapReader
- Added XML sitemap support
- Added recursive sitemap index support
- Added graceful HTTP error handling
- Added robots.txt sitemap discovery
- Added HTML sitemap fallback
- Added HtmlSitemapReader
- Added homepage crawl fallback
- Added shared non-HTML resource filtering
- Prevented analysis of non-HTML resources from sitemaps
- Decoupled URL discovery from SiteCrawler
- Refactored SiteCrawler to consume URL providers
- Improved reporting with page grouping by content quality

### v0.6

- Refactored crawler architecture
- Introduced ReportEntry flow
- Eliminated duplicate HTML fetching
- Simplified InspectoraApplication
- Stabilized reporting pipeline

---

## 🎯 Version 1.0 Goal

- Accept any website URL
- Automatically discover website URLs
- Crawl the entire website
- Analyze content quality
- Perform basic SEO checks
- Generate reports
- Export results to Excel