package generated

final case class Data1113(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1113 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1113 = copy(value = value * k)
  def addTag(t: String): Data1113 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1113 = copy(meta = meta.updated(k, v))
  def merge(other: Data1113): Data1113 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1113 {
  given Ordering[Data1113] = Ordering.by(_.id)
  def empty: Data1113 = Data1113(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1113 =
    Data1113(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1113] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
