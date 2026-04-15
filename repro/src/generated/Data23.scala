package generated

final case class Data23(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data23 = copy(name = name.toUpperCase)
  def scale(k: Double): Data23 = copy(value = value * k)
  def addTag(t: String): Data23 = copy(tags = t :: tags)
  def put(k: String, v: String): Data23 = copy(meta = meta.updated(k, v))
  def merge(other: Data23): Data23 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data23 {
  given Ordering[Data23] = Ordering.by(_.id)
  def empty: Data23 = Data23(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data23 =
    Data23(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data23] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
