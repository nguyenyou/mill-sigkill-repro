package generated

final case class Data1170(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1170 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1170 = copy(value = value * k)
  def addTag(t: String): Data1170 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1170 = copy(meta = meta.updated(k, v))
  def merge(other: Data1170): Data1170 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1170 {
  given Ordering[Data1170] = Ordering.by(_.id)
  def empty: Data1170 = Data1170(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1170 =
    Data1170(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1170] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
