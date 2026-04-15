package generated

final case class Data337(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data337 = copy(name = name.toUpperCase)
  def scale(k: Double): Data337 = copy(value = value * k)
  def addTag(t: String): Data337 = copy(tags = t :: tags)
  def put(k: String, v: String): Data337 = copy(meta = meta.updated(k, v))
  def merge(other: Data337): Data337 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data337 {
  given Ordering[Data337] = Ordering.by(_.id)
  def empty: Data337 = Data337(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data337 =
    Data337(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data337] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
