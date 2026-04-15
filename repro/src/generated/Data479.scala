package generated

final case class Data479(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data479 = copy(name = name.toUpperCase)
  def scale(k: Double): Data479 = copy(value = value * k)
  def addTag(t: String): Data479 = copy(tags = t :: tags)
  def put(k: String, v: String): Data479 = copy(meta = meta.updated(k, v))
  def merge(other: Data479): Data479 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data479 {
  given Ordering[Data479] = Ordering.by(_.id)
  def empty: Data479 = Data479(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data479 =
    Data479(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data479] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
