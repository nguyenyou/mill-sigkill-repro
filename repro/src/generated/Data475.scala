package generated

final case class Data475(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data475 = copy(name = name.toUpperCase)
  def scale(k: Double): Data475 = copy(value = value * k)
  def addTag(t: String): Data475 = copy(tags = t :: tags)
  def put(k: String, v: String): Data475 = copy(meta = meta.updated(k, v))
  def merge(other: Data475): Data475 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data475 {
  given Ordering[Data475] = Ordering.by(_.id)
  def empty: Data475 = Data475(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data475 =
    Data475(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data475] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
