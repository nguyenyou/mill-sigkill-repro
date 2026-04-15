package generated

final case class Data182(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data182 = copy(name = name.toUpperCase)
  def scale(k: Double): Data182 = copy(value = value * k)
  def addTag(t: String): Data182 = copy(tags = t :: tags)
  def put(k: String, v: String): Data182 = copy(meta = meta.updated(k, v))
  def merge(other: Data182): Data182 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data182 {
  given Ordering[Data182] = Ordering.by(_.id)
  def empty: Data182 = Data182(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data182 =
    Data182(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data182] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
