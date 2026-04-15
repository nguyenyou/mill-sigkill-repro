package generated

final case class Data807(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data807 = copy(name = name.toUpperCase)
  def scale(k: Double): Data807 = copy(value = value * k)
  def addTag(t: String): Data807 = copy(tags = t :: tags)
  def put(k: String, v: String): Data807 = copy(meta = meta.updated(k, v))
  def merge(other: Data807): Data807 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data807 {
  given Ordering[Data807] = Ordering.by(_.id)
  def empty: Data807 = Data807(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data807 =
    Data807(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data807] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
