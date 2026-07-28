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

---

## 🚧 In Progress

- [ ] UrlProvider
- [ ] SitemapReader

---

## 📋 Next Steps

- [ ] XML sitemap support
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

v0.5

---

## 📜 Changelog

### v0.5

- Refactored crawler architecture
- Introduced ReportEntry flow
- Eliminated duplicate HTML fetching
- Simplified InspectoraApplication
- Stabilized reporting pipeline

---

## 🎯 Version 1.0 Goal

- Accept any website URL
- Automatically discover sitemaps
- Crawl the entire website
- Analyze content quality
- Perform basic SEO checks
- Generate reports
- Export results to Excel