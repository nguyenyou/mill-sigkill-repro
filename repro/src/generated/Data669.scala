package generated

final case class Data669(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data669 = copy(name = name.toUpperCase)
  def scale(k: Double): Data669 = copy(value = value * k)
  def addTag(t: String): Data669 = copy(tags = t :: tags)
  def put(k: String, v: String): Data669 = copy(meta = meta.updated(k, v))
  def merge(other: Data669): Data669 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data669 {
  given Ordering[Data669] = Ordering.by(_.id)
  def empty: Data669 = Data669(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data669 =
    Data669(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data669] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
