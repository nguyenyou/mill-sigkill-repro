package generated

final case class Data357(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data357 = copy(name = name.toUpperCase)
  def scale(k: Double): Data357 = copy(value = value * k)
  def addTag(t: String): Data357 = copy(tags = t :: tags)
  def put(k: String, v: String): Data357 = copy(meta = meta.updated(k, v))
  def merge(other: Data357): Data357 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data357 {
  given Ordering[Data357] = Ordering.by(_.id)
  def empty: Data357 = Data357(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data357 =
    Data357(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data357] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
