package generated

final case class Data664(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data664 = copy(name = name.toUpperCase)
  def scale(k: Double): Data664 = copy(value = value * k)
  def addTag(t: String): Data664 = copy(tags = t :: tags)
  def put(k: String, v: String): Data664 = copy(meta = meta.updated(k, v))
  def merge(other: Data664): Data664 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data664 {
  given Ordering[Data664] = Ordering.by(_.id)
  def empty: Data664 = Data664(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data664 =
    Data664(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data664] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
