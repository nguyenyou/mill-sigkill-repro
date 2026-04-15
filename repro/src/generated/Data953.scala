package generated

final case class Data953(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data953 = copy(name = name.toUpperCase)
  def scale(k: Double): Data953 = copy(value = value * k)
  def addTag(t: String): Data953 = copy(tags = t :: tags)
  def put(k: String, v: String): Data953 = copy(meta = meta.updated(k, v))
  def merge(other: Data953): Data953 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data953 {
  given Ordering[Data953] = Ordering.by(_.id)
  def empty: Data953 = Data953(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data953 =
    Data953(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data953] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
