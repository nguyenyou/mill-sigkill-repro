package generated

final case class Data1017(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1017 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1017 = copy(value = value * k)
  def addTag(t: String): Data1017 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1017 = copy(meta = meta.updated(k, v))
  def merge(other: Data1017): Data1017 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1017 {
  given Ordering[Data1017] = Ordering.by(_.id)
  def empty: Data1017 = Data1017(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1017 =
    Data1017(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1017] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
