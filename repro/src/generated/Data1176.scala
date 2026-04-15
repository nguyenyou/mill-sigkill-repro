package generated

final case class Data1176(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1176 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1176 = copy(value = value * k)
  def addTag(t: String): Data1176 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1176 = copy(meta = meta.updated(k, v))
  def merge(other: Data1176): Data1176 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1176 {
  given Ordering[Data1176] = Ordering.by(_.id)
  def empty: Data1176 = Data1176(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1176 =
    Data1176(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1176] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
