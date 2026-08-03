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

---

## 📋 Next Steps

- [ ] Sitemap index support (`sitemap_index.xml`)
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

v0.6

---

## 📜 Changelog

### v0.6

- Introduced UrlProvider
- Added SitemapReader
- Added XML sitemap support
- Decoupled URL discovery from SiteCrawler
- Refactored SiteCrawler to consume URL providers
- Improved reporting with page grouping by content quality

### v0.5

- Refactored crawler architecture
- Introduced ReportEntry flow
- Eliminated duplicate HTML fetching
- Simplified InspectoraApplication
- Stabilized reporting pipeline

---

## 🎯 Version 1.0 Goal

- Accept any website URL
- Automatically discover and process sitemaps
- Crawl the entire website
- Analyze content quality
- Perform basic SEO checks
- Generate reports
- Export results to Excel