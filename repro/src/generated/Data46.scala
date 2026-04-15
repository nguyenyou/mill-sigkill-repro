package generated

final case class Data46(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data46 = copy(name = name.toUpperCase)
  def scale(k: Double): Data46 = copy(value = value * k)
  def addTag(t: String): Data46 = copy(tags = t :: tags)
  def put(k: String, v: String): Data46 = copy(meta = meta.updated(k, v))
  def merge(other: Data46): Data46 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data46 {
  given Ordering[Data46] = Ordering.by(_.id)
  def empty: Data46 = Data46(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data46 =
    Data46(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data46] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
