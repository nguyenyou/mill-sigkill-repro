package generated

final case class Data1322(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1322 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1322 = copy(value = value * k)
  def addTag(t: String): Data1322 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1322 = copy(meta = meta.updated(k, v))
  def merge(other: Data1322): Data1322 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1322 {
  given Ordering[Data1322] = Ordering.by(_.id)
  def empty: Data1322 = Data1322(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1322 =
    Data1322(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1322] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
