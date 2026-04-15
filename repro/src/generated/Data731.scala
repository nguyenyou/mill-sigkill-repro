package generated

final case class Data731(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data731 = copy(name = name.toUpperCase)
  def scale(k: Double): Data731 = copy(value = value * k)
  def addTag(t: String): Data731 = copy(tags = t :: tags)
  def put(k: String, v: String): Data731 = copy(meta = meta.updated(k, v))
  def merge(other: Data731): Data731 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data731 {
  given Ordering[Data731] = Ordering.by(_.id)
  def empty: Data731 = Data731(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data731 =
    Data731(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data731] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
