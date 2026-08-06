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

---

## 📋 Next Steps

- [ ] robots.txt sitemap discovery
- [ ] HTML sitemap fallback
- [ ] Homepage crawl fallback
- [ ] Excel export
- [ ] H1 Analyzer
- [ ] ALT Analyzer
- [ ] Meta Description Analyzer
- [ ] SEO Score

---

## ✅ Current Version

v0.7

---

## 📜 Changelog

### v0.7

- Added UrlProvider
- Added SitemapReader
- Added XML sitemap support
- Added recursive sitemap index support
- Added graceful HTTP error handling
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