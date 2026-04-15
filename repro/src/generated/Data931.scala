package generated

final case class Data931(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data931 = copy(name = name.toUpperCase)
  def scale(k: Double): Data931 = copy(value = value * k)
  def addTag(t: String): Data931 = copy(tags = t :: tags)
  def put(k: String, v: String): Data931 = copy(meta = meta.updated(k, v))
  def merge(other: Data931): Data931 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data931 {
  given Ordering[Data931] = Ordering.by(_.id)
  def empty: Data931 = Data931(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data931 =
    Data931(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data931] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
