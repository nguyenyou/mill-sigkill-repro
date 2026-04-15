package generated

final case class Data1235(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1235 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1235 = copy(value = value * k)
  def addTag(t: String): Data1235 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1235 = copy(meta = meta.updated(k, v))
  def merge(other: Data1235): Data1235 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1235 {
  given Ordering[Data1235] = Ordering.by(_.id)
  def empty: Data1235 = Data1235(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1235 =
    Data1235(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1235] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
