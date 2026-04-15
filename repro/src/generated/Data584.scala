package generated

final case class Data584(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data584 = copy(name = name.toUpperCase)
  def scale(k: Double): Data584 = copy(value = value * k)
  def addTag(t: String): Data584 = copy(tags = t :: tags)
  def put(k: String, v: String): Data584 = copy(meta = meta.updated(k, v))
  def merge(other: Data584): Data584 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data584 {
  given Ordering[Data584] = Ordering.by(_.id)
  def empty: Data584 = Data584(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data584 =
    Data584(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data584] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
